/*
 * @Author: Kyle Xu
 * @Date: 2020-09-10 10:32:19
 * @LastEditors: Kyle Xu
 * @LastEditTime: 2020-09-10 22:19:50
 * @Blog: http://kylexu.cn
 * @Github: https://github.com/xxxxxthhh
 * @Mail: kyle_x@foxmail.com
 * @Description:  // write sth about Code
 */
import java.util.List;
import java.util.regex.Pattern;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class GrammarExercise {
    public static void main(String[] args) {
        //需要从命令行读入
        String firstWordList = "";
        String secondWordList = "";
        Scanner scanner = new Scanner(System.in);
        System.out.print("Please input wordList1: ");
        firstWordList = scanner.next();
        System.out.print("Please input wordList2: ");
        secondWordList = scanner.next();

        List<String> result = findCommonWordsWithSpace(firstWordList,secondWordList);
        //按要求输出到命令行
        System.out.print(result);
    }

    public static List<String> findCommonWordsWithSpace(String firstWordList, String secondWordList) {
        //在这编写实现代码
        String regexWord = "[A-z]+";
        Pattern pattern = Pattern.compile(",");

        Stream<String> firstStrem = pattern.splitAsStream(firstWordList);
        Stream<String> secondStream = pattern.splitAsStream((secondWordList));

        System.out.println(firstWordList);
        System.out.println(secondWordList);

        if (!firstStrem.allMatch(s -> s.matches(regexWord)) || !secondStream.allMatch(s -> s.matches(regexWord))){
            throw new RuntimeException("input is valid");
        }

        List<String> firstList = pattern.splitAsStream(firstWordList).map(s -> s.toUpperCase()).distinct().sorted().collect(Collectors.toList());
        List<String> secondList = pattern.splitAsStream(secondWordList).map(s -> s.toUpperCase()).distinct().sorted().collect(Collectors.toList());

        firstList.retainAll(secondList);

        List<String> finalList = firstList.stream().map(s -> s.replace("", " ").trim()).collect(Collectors.toList());

        return finalList;
    }
}
