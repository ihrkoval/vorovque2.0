package vorovque.bot.demo.TelegaApi;

import com.vdurmont.emoji.EmojiParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.methods.send.SendPhoto;
import org.telegram.telegrambots.meta.api.methods.send.SendVideo;
import org.telegram.telegrambots.meta.api.methods.updatingmessages.EditMessageCaption;
import org.telegram.telegrambots.meta.api.methods.updatingmessages.EditMessageText;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.InlineKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.InlineKeyboardButton;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import vorovque.bot.demo.dao.SystemDAO;
import vorovque.bot.demo.pojo.d3posts.Link;
import vorovque.bot.demo.pojo.d3posts.Media;
import vorovque.bot.demo.pojo.d3posts.Post;
import vorovque.bot.demo.utils.HttpUtil;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import static java.lang.Math.toIntExact;


public class Vorovque extends TelegramLongPollingBot {

    String myId = "-300000537";

    @Autowired
    SystemDAO systemDAO;

    @Override
    public String getBotUsername() {
        return "Vorovque";
        //возвращаем юзера
    }

    @Override
    public void onUpdateReceived(Update e) {
        System.out.println("UPDATE RECIVED");
        // Тут будет то, что выполняется при получении сообщения

        Long chat_id = null;
        String firstname = null;
        String lastName = null;
        String username = null;
        String text = null;
        try {
            chat_id = e.getMessage().getChatId();
            firstname =  e.getMessage().getFrom().getFirstName();
            lastName = e.getMessage().getFrom().getLastName();
            username = e.getMessage().getFrom().getUserName();
            text = e.getMessage().getText();
            System.out.println("caht = "+chat_id);
            System.out.println("firstname = "+firstname);
            System.out.println("lastname = "+lastName);
            System.out.println("username = "+username);
            System.out.println("text =  "+e.getMessage().getText());
            System.out.println("toString "+e.getMessage().toString());
        } catch (NullPointerException en){
            en.printStackTrace();
        }



        if (e.hasCallbackQuery()) {
            // Set variables
            String call_data = e.getCallbackQuery().getData();
            long callback_message_id = e.getCallbackQuery().getMessage().getMessageId();
            long callback_chat_id = e.getCallbackQuery().getMessage().getChatId();
            System.out.println(call_data);
            System.out.println(callback_message_id);
            System.out.println(callback_chat_id);
            String answer = "";

            if (call_data.startsWith("post_message")) {
               answer = "**POSTED** "+answer;
                System.out.println(call_data);
                String postId = call_data.split("-")[1];
                Post p = systemDAO.getPostById(Integer.valueOf(postId));
                sendPost(p, "@you_lose_soochello", false);
                }

            if (call_data.startsWith("delete_message")){
                answer = "**DELETED** "+answer;
                }

            if (e.getCallbackQuery().getMessage().getCaption() != null){
                answer = answer + e.getCallbackQuery().getMessage().getCaption();
                EditMessageCaption newCaption = new EditMessageCaption().setChatId(String.valueOf(callback_chat_id));
                newCaption.setMessageId(toIntExact(callback_message_id));
                newCaption.setCaption(answer);
                try {
                    execute(newCaption);
                } catch (TelegramApiException ee) {
                    ee.printStackTrace();
                }
            } else if (e.getCallbackQuery().getMessage().getText() != null){
                EditMessageText editMessageText = new EditMessageText().setChatId(String.valueOf(callback_chat_id))
                        .setMessageId(toIntExact(callback_message_id))
                        .setText(answer+e.getCallbackQuery().getMessage().getText());
                try {
                    execute(editMessageText);
                } catch (TelegramApiException ee) {
                    ee.printStackTrace();
                }
                System.out.println(e.getCallbackQuery().getMessage().getCaption() + " CAPTION AND TEXT "+e.getCallbackQuery().getMessage().getText());
            }
        } 
    }


    private InlineKeyboardMarkup getKeyboard(String postID){
        InlineKeyboardMarkup markupInline = new InlineKeyboardMarkup();
        List<List<InlineKeyboardButton>> rowsInline = new ArrayList<>();
        List<InlineKeyboardButton> rowInline = new ArrayList<>();
        String post = EmojiParser.parseToUnicode(":white_check_mark:");
        String edit = EmojiParser.parseToUnicode(":pencil2:");
        String delete = EmojiParser.parseToUnicode(":x:");

        rowInline.add(new InlineKeyboardButton().setText(post).setCallbackData("post_message-"+postID));
        // rowInline.add(new InlineKeyboardButton().setText(edit).setCallbackData("edit_message_text"));
        rowInline.add(new InlineKeyboardButton().setText(delete).setCallbackData("delete_message-"+postID));
        // Set the keyboard to the markup
        rowsInline.add(rowInline);
        // Add it to the message
        markupInline.setKeyboard(rowsInline);
        return markupInline;
    }

    @Override
    public String getBotToken() {
        return "576318633:AAHHY8kZoyr9p4k5WiuACPL_vZidhbmHhr0";
        //Токен бота
    }

    public void sendMe(Post p){
        sendPost(p, myId, true);
    }


    private void sendPost(Post p, String chatID, boolean keyboard) {
        boolean isPosted = false;
        String mainImageUrl = p.getMainImageUrl();
        String videoUrl = null;
        String p_title = fixBRtag(p.getTitle());
        String p_text = fixBRtag(p.getData().getText());
        Link p_d_link =  p.getData().getLink();
        Media p_d_media = p.getData().getMedia(); //TODO MEDIA IS GIF
        String media_image = null;
        String type = "";
        String postId = "";
        if (keyboard){
            postId = String.valueOf(p.getId());
        }


        if (p_d_link != null){
            if (p.getData().getLink().getType() != null)
            type =  p.getData().getLink().getType();

        } else

        if (p_d_media != null){
            type = p_d_media.getRType();
            if (type.equals("image")){
              String video =  p_d_media.getVideo();
              if (video != null && video.length() > 6){
                  type = "video";
                  videoUrl = video;
              }
            }
        }

        if (p_text.length() > 5000){
            p_text = "";
        }

        if (type.equals("video")){

            System.out.println("type equals video");
            if (videoUrl == null || videoUrl.equals("null")) {
                try {
                    videoUrl = p.getData().getLink().getVideo();
                    if (videoUrl == null || videoUrl.equals("null"))
                        videoUrl = p.getData().getLink().getUrl();
                    System.out.println("videourl is " + videoUrl);
                } catch (NullPointerException e) {
                    System.out.println("fail to get video from data/link/video. try to get from data/link/url");
                    videoUrl = p.getData().getLink().getUrl();
                    System.out.println("videourl is " + videoUrl);
                }
            }

        }
        System.out.println("-------------------------");
        System.out.println(type);
        System.out.println(p_title);
        System.out.println(p_text);
        System.out.println(mainImageUrl);
        System.out.println(videoUrl);


        if (videoUrl != null){
            sendVideo(p_title, p_text,videoUrl, chatID, keyboard, postId);
            System.out.println("type is video ");
            isPosted = true;
         //   videoFile.delete();
        }
        if ((type.equals("embed") || type.equals("web")) && p_d_link != null){
            sendHrefContent(p_title, p_text, p_d_link.getUrl(), chatID, keyboard, postId);
            isPosted = true;
        }

        if (mainImageUrl != null && type.equals("image")){
            try {
                videoUrl = p.getData().getLink().getVideo();
                System.out.println("WTF? THIS IMG IS A VIDEO??");
                sendVideo(p_title, p_text, videoUrl, chatID, keyboard, postId);
            } catch (NullPointerException e){
                sendPhoto(p_title, p_text, mainImageUrl, chatID, keyboard, postId);
            }
            isPosted = true;
        }

        if (!isPosted){
            System.out.println("ELSE type "+type);
            SendMessage s = new SendMessage();
            s.setParseMode("html");
            System.out.println(p_title);
            System.out.println(p_text);
            s.setChatId(myId); // Боту может писать не один человек, и поэтому чтобы отправить сообщение, грубо говоря нужно узнать куда его отправлять
            s.setText("<a href=\"" + mainImageUrl + "\">.</a>" + p_title + " " + p_text + " ");
            try {
                execute(s);
            } catch (TelegramApiException e) {
                e.printStackTrace();
                System.out.println("ERROR --------------");
                System.out.println(type);
                System.out.println(mainImageUrl);
                System.out.println(p_title);
                System.out.println(p_text);
                p_text = p_text.replace("<","_ ").replace(">", " _");
                p.getData().setText(p_text);
                           


            }
        }
    }

    private String fixBRtag(String text) {

        String fixString = text;
        boolean isTagOpen = true;
        while (fixString.contains("br")){
            if (isTagOpen == true) {
                fixString = fixString.replaceFirst("br","b");
                isTagOpen = false;
            }
            if(!isTagOpen) {
                fixString = fixString.replaceFirst("br","/b");
                isTagOpen = true;
            }
        }

        Integer lastOpenB = fixString.lastIndexOf("<b>");
        Integer lastCloseB = fixString.lastIndexOf("</b>");

        if (lastOpenB > lastCloseB){
            String part1 = fixString.substring(0,fixString.lastIndexOf("<b>"));
            String part2 = fixString.substring(fixString.lastIndexOf("<b>")+3,fixString.length());
            fixString = part1+part2;

        }

        fixString = fixString
                .replace("*", "\\*")
                .replace("[", "\\[")
                .replace("<i>", " ")
                .replace("</i>", " ")
                .replace("<span class=\"irony\">", "<i>")
                .replace("</span>", "</i>")
                .replace("`", "\\`")
                .replace("'", "")
                .replace("<sub>", " ")
                .replace("<span class=\"moderator\">", "<i>")
                .replace("</sub>", " ").replace("<sup>"," ").replace("</sup>"," ");

        return fixString;
    }

    private void sendVideo(String title, String text, String fileUrl, String chatID, boolean keyboard, String postId){
        System.out.println("type is video ");

        System.out.println(fileUrl);
        SendVideo sendVideo = new SendVideo();
        sendVideo.setVideo(new HttpUtil().getFileByURL(fileUrl));
        sendVideo.setCaption("<b>" + title + "</b>\n" + text);
        sendVideo.setChatId(chatID);
        sendVideo.setParseMode("html");
        if (keyboard)
        sendVideo.setReplyMarkup(getKeyboard(postId));
        try {
            System.out.println("TRY TO SEND VIDEO");
            execute(sendVideo);
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }

    private void sendHrefContent(String p_title, String p_text, String href, String chatID, boolean keyboard, String postId){
        String text = "";
        if (p_text.length() > 1000)
            p_text = "";
       if (p_title != null){
           text = "<a href=\"" + href + "\">"+ p_title +" </a> \n" + p_text;
       } else {
           text = href;
       }
        SendMessage s = new SendMessage();
        s.setParseMode("html");
        System.out.println(p_title);
        System.out.println(p_text);
        s.setChatId(chatID); // Боту может писать не один человек, и поэтому чтобы отправить сообщение, грубо говоря нужно узнать куда его отправлять
        s.setText(text);
        if (keyboard)
        s.setReplyMarkup(getKeyboard(postId));
        try {
            execute(s);
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }

    private void sendPhoto(String p_title, String p_text, String href, String chatID, boolean keyboard, String postID){
        SendPhoto sendPhoto = new SendPhoto();
        sendPhoto.setPhoto(href);
        if (p_text.length() > 1000){
            p_text = " ";
        }
        sendPhoto.setCaption("<b>" + p_title + "</b>\n" + p_text);
        sendPhoto.setChatId(chatID);
        sendPhoto.setParseMode("html");
        if (keyboard)
        sendPhoto.setReplyMarkup(getKeyboard(postID));
        try {
            execute(sendPhoto);
        } catch (TelegramApiException e) {
            System.out.println(p_text.length() + " TEXT LENGTH");
            e.printStackTrace();
        }
    }




}
