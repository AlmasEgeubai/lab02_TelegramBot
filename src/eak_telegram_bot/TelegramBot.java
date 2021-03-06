package eak_telegram_bot;

import eak_telegram_bot.Solve;
import java.io.File;
import org.telegram.telegrambots.extensions.bots.commandbot.TelegramLongPollingCommandBot;
import org.telegram.telegrambots.meta.api.methods.ParseMode;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.methods.send.SendPhoto;
import org.telegram.telegrambots.meta.api.objects.InputFile;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

public class TelegramBot extends TelegramLongPollingCommandBot {

    public static SendPhoto getDefaultMessage(String chatId) {
        return SendPhoto
                .builder()
                .chatId(chatId)
                .photo(new InputFile(new File("primer.png").getAbsoluteFile()))
                .parseMode(ParseMode.MARKDOWN)
                .caption("Чтобы расчитать математическое значение по заданному алгоритму введите команду '/solve', где "
                        + "первый аргумент это 'x', второй это 'a', а третий 'b'\n\n"
                        + "Например, если 'x' = 1, 'a' = 5, 'b' = 10: '/solve 11 4 8'")
                .build();
    }

    public TelegramBot() {

        register(new Solve());

        registerDefaultAction((absSender, message) -> {
            SendMessage commandUnknownMessage = SendMessage
                    .builder()
                    .chatId(message.getChatId().toString())
                    .text("Команда " + message.getText() + " неизвестна этому боту.")
                    .build();
            try {
                absSender.execute(commandUnknownMessage);
                absSender.execute(getDefaultMessage(message.getChatId().toString()));
            } catch (TelegramApiException e) {
            }
        });
    }

    @Override
    public void processNonCommandUpdate(Update update) {

        if (update.hasMessage()) {
            Message message = update.getMessage();

            try {
                execute(getDefaultMessage(message.getChatId().toString()));
            } catch (TelegramApiException e) {
            }
        }
    }

    //Получаем никнейм бота
    @Override
    public String getBotUsername() {
        return "EAK_Telegrambot";
    }

    //Получаем токен бота
    @Override
    public String getBotToken() {
        return "1810004153:AAHz7oVyQGmVYUC9cnx0ezfdbBu6zF8I424";
    }

}
