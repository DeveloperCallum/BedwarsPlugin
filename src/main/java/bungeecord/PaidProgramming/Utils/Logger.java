package bungeecord.PaidProgramming.Utils;

import net.md_5.bungee.api.chat.BaseComponent;
import net.md_5.bungee.api.chat.TextComponent;

import java.util.Date;

public class Logger{
    public static void message(String message){
        System.out.println("[" + getDate() + "] " + message);
    }

    public static void message(BaseComponent message){
        if (message == null || ((TextComponent) message).getText().isEmpty()) return;
        System.out.println("[" + getDate() + "] " + message.toPlainText());
    }

    private static String getDate(){
        return new Date().toLocaleString().split(" ")[1].trim();
    }
}
