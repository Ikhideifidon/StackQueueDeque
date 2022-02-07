package com.ikhideifidon;


/**
 * A Class of Stack Exercises
 */
public class StackExercises {

    /**
     * A generic method for reversing an array
     * @param array: An array of a type parameter
     * @param <E>: Type parameter
     * @return A reversed array of type parameter
     */
    public static <E extends Object & Comparable<E>> E[] reverseArray(E[] array) {
        AbstractCollections<E> arrayStack = new ArrayStack<>(array.length);
        for (E e : array) arrayStack.push(e);
        for (int i = 0; i < array.length; i++)
            array[i] = arrayStack.pop();
        return array;
    }

    /**
     * Tests if delimiters in the given expression are properly matched.
     * @param expression: A String inputs
     * @return  boolean
     */
    public static boolean isMatched(String expression) {
        final String open = "({[";
        final String close = ")}]";
        AbstractCollections<Character> arrayStack = new ArrayStack<>();
        for (char c : expression.toCharArray()) {
            if (open.indexOf(c) != -1)
                arrayStack.push(c);
            else if (close.indexOf(c) != -1) {
                if (arrayStack.isEmpty())
                    return false;
                if (close.indexOf(c) != open.indexOf(arrayStack.pop()))
                    return false;
            }
        }
        return true;
    }

    /**
     * Tests if every opening tag has a matching closing tag in HTML string
     * Sample: <head> <body> The body tag is enclosed in the head tag </body> </head>
     * Tags: <head>, <body>, </body> and </head>
     * Words in Tags: head, /head, body and /body.
     * @param html: A string with some html tags
     * @return boolean
     */
    public static boolean isHTMLMatched(String html) {
        AbstractCollections<String> arrayStack = new ArrayStack<>();
        int j = html.indexOf('<');                  // The first '<' character
        while (j != -1) {
            int k = html.indexOf('>', j + 1);           // The first '>' character
            if (k == -1)
                return false;
            String wordInTag = html.substring(j+1, k);              // Strip away '< >'
            // Check if the word in tag starts with '/' to confirm if
            // tag is an opening tag or a closing tag.
            if (!wordInTag.startsWith("/"))
                arrayStack.push(wordInTag);
            // If word in tag starts with '/', it simply means that there is either a preceding
            // opening tag or there is no preceding opening tag in which case means our arrayStack
            // is an empty stack.
            else {
                if (arrayStack.isEmpty())
                    return false;
                if (!wordInTag.substring(1).equals(arrayStack.pop()))           // Mismatched word in tag
                    return false;
            }
            j = html.indexOf('<', k+1);         // Advance to the next available '<' character (if any)
        }
        return arrayStack.isEmpty();
    }
}

