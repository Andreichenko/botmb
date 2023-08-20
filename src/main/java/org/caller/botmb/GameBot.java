package org.caller.botmb;

import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.objects.Update;

public class GameBot extends TelegramLongPollingBot {

    @Override
    public void onUpdateReceived(Update update) {
        if (update.hasMessage() && update.getMessage().hasText()) {

        }
    }

    @Override
    public String getBotUsername() {
        return "Bomber";
    }

    @Override
    public String getBotToken() {
        return "TIJDUHFFYEHFEJD232DHJKFKDKDD";
    }
}
