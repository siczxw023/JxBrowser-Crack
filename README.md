# Jxbrowser Crack Util

## Sample Code
```$xslt
 public static void main(String[] args) {
        //start hack
        JxBrowserHackUtil.hack(JxVersion.V6_18);
        
        String identity = UUID.randomUUID().toString();
        BrowserContextParams params = new BrowserContextParams("tmp/browser/" + identity);
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
```

## Console Output
```$xslt
-- Product name: JxBrowser
-- Licensed version: 6.x
-- Licensed to: 
-- License type: Evaluation
-- Generation date: 2017-4-12
-- Expiration date: 2217-6-12
-- License info: JxBrowser Demo License
-- Current date: 2018-11-19
JxBrowser license valid.

```


## How To Change Version
* Modify pom.xml ${jx.version} to target version
* Change input version of JxBrowserHackUtil.hack();


## Support Versions
* V6.9
* V6.18
* V6.20

