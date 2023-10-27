package generics_sets_maps.entities;

import java.time.Instant;
import java.util.Objects;

public class LogEntry {

    private final String username;
    private final Instant instant;

    public LogEntry(String username, Instant instant) {
        this.username = username;
        this.instant = instant;
    }

    /*
    Override gerado automaticamente pela IDE, considerando apenas o atributo username
    como parâmetro de comparação. Necessário para compor o compareTo() de um Set.
    */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LogEntry logEntry = (LogEntry) o;
        return Objects.equals(username, logEntry.username);
    }

    /*
    Override gerado automaticamente pela IDE, considerando apenas o atributo username
    como parâmetro de comparação. Necessário para compor o compareTo() de um Set.
    */
    @Override
    public int hashCode() {
        return Objects.hash(username);
    }

}
