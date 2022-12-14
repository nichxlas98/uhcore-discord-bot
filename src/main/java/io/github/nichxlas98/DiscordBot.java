package io.github.nichxlas98;

import io.github.nichxlas98.commands.scriptCommand;
import io.github.nichxlas98.commands.suggestionCommand;
import io.github.nichxlas98.listeners.ModalListeners;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.entities.Activity;
import net.dv8tion.jda.api.entities.Guild;
import net.dv8tion.jda.api.interactions.commands.OptionType;
import net.dv8tion.jda.api.interactions.commands.build.OptionData;

import javax.security.auth.login.LoginException;

public class DiscordBot {

    public static void main(String[] args) throws LoginException, InterruptedException {

        // UhCore Discord Bot by @nichxlas98
        JDA bot = JDABuilder.createDefault("TOKEN")
                .setActivity(Activity.watching("UhCore's Development."))
                .addEventListeners(new suggestionCommand())
                .addEventListeners(new scriptCommand(), new ModalListeners())
                .build().awaitReady();


        Guild guild = bot.getGuildById("1010218336346452158");
        if (guild != null) {
            guild.upsertCommand("suggest", "Submit your game/community suggestions with this command!")
                    .addOption(OptionType.STRING, "title", "Your suggestion title.", true)
                    .addOption(OptionType.STRING, "suggestion", "Your suggestion description.", true)
                    .addOptions(
                            new OptionData(OptionType.STRING, "type", "Your suggestion type.", true)
                                    .addChoice("Game Suggestion", "Game Suggestion.")
                                    .addChoice("Community Suggestion", "Community Suggestion."))
                    .queue();
            guild.upsertCommand("script", "Script changelogs").queue();
        }

    }

}
