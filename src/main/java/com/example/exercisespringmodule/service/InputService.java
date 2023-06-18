package com.example.exercisespringmodule.service;

import com.example.exercisespringmodule.exceptionhandler.ExceptionKontrolloFjalen;
import lombok.Data;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Data
@Service
public class InputService {

    public int checkVowels(String insertedWord) throws ExceptionKontrolloFjalen {
        String word = insertedWord;
//        List<Character> vowels = new ArrayList<>();
//
//        for (char ch : word.toCharArray()) {
//            if (isVowel(ch)) {
//                vowels.add(ch);
//            }
//        }

        List<Character> vowels = word.chars()
                .mapToObj(ch -> (char) ch)
                .filter(ch -> isVowel(ch))
                .collect(Collectors.toList());

//         System.out.println("Vowels in the word '" + word + "': " + vowels);

        if(vowels.size()==0){
            throw new ExceptionKontrolloFjalen("Nuk ka zanore");
        }
        return vowels.size();
    }

    private static boolean isVowel(char ch) {
        char lowercaseCh = Character.toLowerCase(ch);
        return lowercaseCh == 'a' || lowercaseCh == 'e' || lowercaseCh == 'i' || lowercaseCh == 'o' || lowercaseCh == 'u' || lowercaseCh == 'y' || lowercaseCh == 'ë';
    }
}
