package Udemic;

import java.util.ArrayList;
import java.util.List;

public class U1_111 {
     public static void main(String[] args) {
        List<String> langs = new ArrayList<>();
        langs.add("Ruby");
        langs.add("Perl");
        langs.add("Perl");
        langs.add("Closure");
        if (langs.remove("Perl")) langs.add("Emacs Lisp");
        System.out.println(langs);
        // [Ruby, Perl, Closure, Emacs Lisp]
    }
}
