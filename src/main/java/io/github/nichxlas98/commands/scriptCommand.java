package io.github.nichxlas98.commands;

import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import net.dv8tion.jda.api.interactions.commands.OptionMapping;
import net.dv8tion.jda.api.interactions.components.ActionRow;
import net.dv8tion.jda.api.interactions.components.Modal;
import net.dv8tion.jda.api.interactions.components.text.TextInput;
import net.dv8tion.jda.api.interactions.components.text.TextInputStyle;
import net.dv8tion.jda.api.utils.TimeFormat;
import org.jetbrains.annotations.NotNull;

import java.awt.*;
import java.util.concurrent.TimeUnit;

public class scriptCommand extends ListenerAdapter {

    @Override
    public void onSlashCommandInteraction(@NotNull SlashCommandInteractionEvent event) {
        if (event.getName().equals("script")) {

            TextInput version = TextInput.create("script-version", "Version", TextInputStyle.SHORT)
                    .setPlaceholder("Build version...")
                    .setRequired(true)
                    .build();

            TextInput changes = TextInput.create("script-changes", "Changelog", TextInputStyle.PARAGRAPH)
                    .setPlaceholder("New changes...")
                    .setRequired(true)
                    .build();

            Modal modal = Modal.create("script-modal", "Changelog")
                    .addActionRows(ActionRow.of(version), ActionRow.of(changes))
                    .build();

            event.replyModal(modal).queue();
        }
    }
}
