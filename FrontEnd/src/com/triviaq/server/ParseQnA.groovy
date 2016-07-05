package com.triviaq.server

import com.triviaq.client.common.QnAData;

/**
 * Parse trivia question and answer which is in plain text format.
 */
class ParseQnA {

    def parsePlainText(String text) {
        QnAData qnaData = new QnAData();
        text.eachLine { line ->
            def l = line.trim();
            if (l.length() > 0) {
                if (qnaData.question.length() == 0) {
                    qnaData.question = l;
                } else {
                    l = l.replaceFirst(/\d+[)\.\] ]+/, "")
                    l = l.trim()
                    qnaData.choices.add(l);
                }
            }
        }
        return qnaData;
    }
    public static void main(String [] args) {
        ParseQnA parser = new ParseQnA();
        def qnaData = parser.parsePlainText('''

Q) This is a question.

1) Choice
2. Choice


3 Choice 

44  ]. Last choice
''')
        System.out.println(qnaData.choices);
    } 
}
