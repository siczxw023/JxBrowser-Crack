package potato.jx.main;

import com.teamdev.jxbrowser.chromium.Browser;
import com.teamdev.jxbrowser.chromium.BrowserContext;
import com.teamdev.jxbrowser.chromium.BrowserContextParams;
import com.teamdev.jxbrowser.chromium.swing.BrowserView;
import potato.jx.crack.JxBrowserHackUtil;
import potato.jx.crack.JxVersion;

import javax.swing.*;
import java.awt.*;
import java.util.UUID;

/**
 * @author zh_zhou
 * created at 2018/11/19 09:50
 * Copyright [2018] [zh_zhou]
 */
public class SampleCode {
    public static void main(String[] args) {
        //start hack
        JxBrowserHackUtil.hack(JxVersion.V6_22);

        String identity = UUID.randomUUID().toString();
        BrowserContextParams params = new BrowserContextParams("temp/browser/" + identity);
        BrowserContext context1 = new BrowserContext(params);
        Browser browser = new Browser(context1);
        BrowserView view = new BrowserView(browser);
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.add(view,BorderLayout.CENTER);
        frame.setSize(700,500);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

        browser.loadURL("https://www.baidu.com/");

    }
}
