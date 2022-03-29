package task;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;

public class WebAddressParser {
    private URL url;
    public WebAddressParser(String url) {
        try {
            this.url = new URL(url);
            }
        catch (MalformedURLException e) {
            this.url = null;
        }

    }
    public String getLogin() {
        return "";
    }
    public String getPassword(){
        return "";
    }
    public String getScheme() {
        if (url != null) {
            return url.getProtocol();
        }
        return "";
    }
    public boolean isValid() {
        return (url != null);
    }
    public String getHost() {
        if (url != null) {
            return url.getHost();
        } else {
            return "";
        }
    }
    public String getPort() {
        return "";
    }
    public String getUrl() {
        if (url != null) {
            return url.getPath().replaceFirst("/", "");
        } else {
            return "";
        }
    }
    public HashMap<String,String> getParameters() {
        return new HashMap<>();
    }
    public String getFragment() {
        return "";
    }

}
