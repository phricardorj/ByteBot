package br.com.phricardo.javadiscordbot.listeners.events;

import static java.lang.String.format;

import lombok.RequiredArgsConstructor;
import org.javacord.api.event.server.member.ServerMemberJoinEvent;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ServerWelcomeEvent {

  private static final long serverWelcomeChannelId = 968360066396856373L;

  public void execute(final ServerMemberJoinEvent event) {
    final var server = event.getServer();
    final var user = event.getUser().getNicknameMentionTag();
    final var channel = server.getTextChannelById(serverWelcomeChannelId);
    channel.ifPresent(c -> c.sendMessage(format("Seja bem-vindo(a) ao nosso Servidor, %s!", user)));
  }
}
