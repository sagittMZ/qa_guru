package utils;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.hc.client5.http.classic.methods.HttpGet;
import org.apache.hc.client5.http.impl.classic.CloseableHttpClient;
import org.apache.hc.client5.http.impl.classic.CloseableHttpResponse;
import org.apache.hc.client5.http.impl.classic.HttpClients;
import org.apache.hc.core5.http.HttpResponse;

import java.io.*;
import java.util.*;
import java.util.concurrent.ThreadLocalRandom;

import static com.codeborne.selenide.Selectors.byAttribute;
import static com.codeborne.selenide.Selectors.byName;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class BaseMethods {
    private final static String GITHUB_LOGIN_URL = "https://github.com/login";
    private final static String CONFIG_PATH ="/home/sagitt/CodePractice/mma_rank/src/test/sources/config.properties";



    public static void githubLogin() {
        open(GITHUB_LOGIN_URL);

        FileInputStream fileInputStream;
        //инициализируем специальный объект Properties
        Properties prop = new Properties();

        try {

            fileInputStream = new FileInputStream(CONFIG_PATH);
            prop.load(fileInputStream);

            String site = prop.getProperty("site");
            String loginToSite = prop.getProperty("login");
            String passwordToSite = prop.getProperty("password");
            $(byName("login")).val(loginToSite);
            $(byName("password")).val(passwordToSite);
            $(byAttribute("value","Sign in")).click();


        } catch (IOException e) {
            System.out.println("Ошибка в программе: файл " + CONFIG_PATH + " не обнаружено");
            e.printStackTrace();
        }
    }

    public  String getCurrentTimeStamp()
    {
        String timestamp = new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss z").format(new Date());
        return timestamp;
    }
    public  String generateDescription() {

        int wordsCount = ThreadLocalRandom.current().nextInt(4, 10);
        List<String> words = new ArrayList<String>();
        for (int i = 0; i <= wordsCount; i++) {
            words.add(generateText(10,25));
        }
        String listString = StringUtils.join(words, " ");

        return listString;
    }

    public  String generateText(Integer min_characters, Integer max_characters) {
        int randomNum = ThreadLocalRandom.current().nextInt(min_characters, max_characters);
        String generatedString = RandomStringUtils.randomAlphabetic(randomNum);
        return generatedString;
    }

    public static String getRequest(String url_path) throws IOException
    {
        CloseableHttpClient httpclient = HttpClients.createDefault();
        HttpGet httpget = new HttpGet(url_path);
        HttpResponse httpresponse = httpclient.execute(httpget);
        Scanner sc = new Scanner(((CloseableHttpResponse) httpresponse).getEntity().getContent());
        StringBuffer result = new StringBuffer();
        int statuscode = httpresponse.getCode();
        if (statuscode == 200) {

            while (sc.hasNext()) {
                result.append(sc.nextLine());
            }
        }
        else
        {
            System.out.println("Server died :-)");
        }
        return String.valueOf(result);
    }


}
