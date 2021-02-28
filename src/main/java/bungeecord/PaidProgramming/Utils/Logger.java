package bungeecord.PaidProgramming.Utils;

import net.md_5.bungee.api.chat.BaseComponent;

import java.util.Date;

public class Logger{
    public static void message(String message){
        System.out.println("[" + getDate() + "] " + message);
    }

    public static void message(BaseComponent message){
        System.out.println("[" + getDate() + "] " + message.toPlainText());
    }

    private static String getDate(){
        return new Date().toLocaleString().split(" ")[1].trim();
    }
}
