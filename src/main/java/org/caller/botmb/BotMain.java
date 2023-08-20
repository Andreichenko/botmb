package org.caller.botmb;

import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import org.telegram.telegrambots.updatesreceivers.DefaultBotSession;

public class BotMain {
    public static void main(String[] args) {
        TelegramBotsApi botsApi = null;
        try {
            botsApi = new TelegramBotsApi(DefaultBotSession.class);
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }

        try {
            botsApi.registerBot(new GameBot());
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }
}
