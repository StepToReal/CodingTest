package com.code.codingtest.skillcheck.level3;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Problem_matchingScore {
    public static void main(String[] args) {
        String word = "blind";
        String[] pages = {"<html lang=\"ko\" xml:lang=\"ko\" xmlns=\"http://www.w3.org/1999/xhtml\">\n<head>\n  <meta charset=\"utf-8\">\n  <meta property=\"og:url\" content=\"https://a.com\"/>\n</head>  \n<body>\nBlind Lorem Blind ipsum dolor Blind test sit amet, consectetur adipiscing elit. \n<a href=\"https://b.com\"> Link to b </a>\n</body>\n</html>", "<html lang=\"ko\" xml:lang=\"ko\" xmlns=\"http://www.w3.org/1999/xhtml\">\n<head>\n  <meta charset=\"utf-8\">\n  <meta property=\"og:url\" content=\"https://b.com\"/>\n</head>  \n<body>\nSuspendisse potenti. Vivamus venenatis tellus non turpis bibendum, \n<a href=\"https://a.com\"> Link to a </a>\nblind sed congue urna varius. Suspendisse feugiat nisl ligula, quis malesuada felis hendrerit ut.\n<a href=\"https://c.com\"> Link to c </a>\n</body>\n</html>", "<html lang=\"ko\" xml:lang=\"ko\" xmlns=\"http://www.w3.org/1999/xhtml\">\n<head>\n  <meta charset=\"utf-8\">\n  <meta property=\"og:url\" content=\"https://c.com\"/>\n</head>  \n<body>\nUt condimentum urna at felis sodales rutrum. Sed dapibus cursus diam, non interdum nulla tempor nec. Phasellus rutrum enim at orci consectetu blind\n<a href=\"https://a.com\"> Link to a </a>\n</body>\n</html>"};
        //a.com=4.5 b.com=4 c.com=1.5

//        String word = "Muzi";
//        String[] pages = {"<html lang=\"ko\" xml:lang=\"ko\" xmlns=\"http://www.w3.org/1999/xhtml\">\n<head>\n  <meta charset=\"utf-8\">\n  <meta property=\"og:url\" content=\"https://careers.kakao.com/interview/list\"/>\n</head>  \n<body>\n<a href=\"https://programmers.co.kr/learn/courses/4673\"></a>#!MuziMuzi!)jayg07con&&\n\n</body>\n</html>", "<html lang=\"ko\" xml:lang=\"ko\" xmlns=\"http://www.w3.org/1999/xhtml\">\n<head>\n  <meta charset=\"utf-8\">\n  <meta property=\"og:url\" content=\"https://www.kakaocorp.com\"/>\n</head>  \n<body>\ncon%\tmuzI92apeach&2<a href=\"https://hashcode.co.kr/tos\"></a>\n\n\t^\n</body>\n</html>"};
        //careers.kakao.com/interview/list=0 www.kakaocorp.com=1

        System.out.println(new Problem_matchingScore().solution(word, pages));
    }

    public int solution(String word, String[] pages) {
        List<WebPage> webPageList = new ArrayList<>();
        int index = 0;

        for (String page : pages) {
            WebPage webPage = new WebPage();

            webPage.index = index++;

            // set url
            String urlTag = "<meta property=\"og:url\" content=\"";
            int metaTagIndex = page.indexOf(urlTag) + urlTag.length();
            webPage.url = page.substring(metaTagIndex, page.indexOf("\"", metaTagIndex));

            // set linkUrl
            String linkTag = "<a href=\"";
            int linkTagIndex = page.indexOf(linkTag);

            while (linkTagIndex != -1) {
                linkTagIndex += linkTag.length();
                webPage.otherLinkUrl.add(page.substring(linkTagIndex, page.indexOf("\"", linkTagIndex)));

                linkTagIndex = page.indexOf(linkTag, linkTagIndex);
            }

            // set basicScore
            String[] pageElements = page.split("[^a-zA-Z]");

            for (String pageElement : pageElements) {
                if (word.equalsIgnoreCase(pageElement)) {
                    webPage.basicScore++;
                }
            }

            webPage.matchingScore = webPage.basicScore;

            webPage.setLinkScore();

            webPageList.add(webPage);
        }

        for (WebPage page : webPageList) {

            for (WebPage linkPage : webPageList) {
                if (page != linkPage && linkPage.otherLinkUrl.contains(page.url)) {
                    page.matchingScore += linkPage.linkScore;
                }
            }
        }

        Collections.sort(webPageList);

        return webPageList.get(0).index;
    }
}

class WebPage implements Comparable<WebPage> {
    int index;
    String url;
    List<String> otherLinkUrl;
    int basicScore;
    double linkScore; // 해당 웹 페이지로 링크가 걸린 다른 웹 페이지의 기본점수 / 그 웹 페이지의 외부링크 수의 총 합
    double matchingScore; // 기본점수 + 링크점수

    public WebPage () {
        otherLinkUrl = new ArrayList<>();
    }

    public void setLinkScore() {
        linkScore = (double)basicScore / otherLinkUrl.size();
    }

    @Override
    public int compareTo(WebPage o) {
        if (matchingScore == o.matchingScore) {
            return index - o.index;
        } else {
            return Double.compare(o.matchingScore, matchingScore);
        }
    }
}
