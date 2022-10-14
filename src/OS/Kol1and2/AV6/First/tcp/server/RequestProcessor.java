package OS.Kol1and2.AV6.First.tcp.server;

import java.util.HashMap;

public class RequestProcessor {
    public String getCommand() {
        return command;
    }

    public String getUri() {
        return uri;
    }

    public String getVersion() {
        return version;
    }

    public HashMap<String, String> getHeaders() {
        return headers;
    }

    private String command;
    private String uri;
    private String version;

    private HashMap<String, String> headers;

    private RequestProcessor(String[] request) {
        String cmd = request[0];
        String[] parts = cmd.split("\\s+");
        this.command = parts[0];
        this.uri = parts[1];
        this.version = parts[2];
        headers = new HashMap<>();

        for (int i = 1; i < request.length; i++) {
            parts = request[i].split(":\\s+");

            headers.put(parts[0], parts[1]);


        }


    }

    public static RequestProcessor of(String data) {
        return new RequestProcessor(data.split("\n"));
    }
}
