package com.ikhideifidon;

import java.util.*;

public class Main {

    public static void main(String[] args) throws CloneNotSupportedException {
        Random rand = new Random();
        rand.setSeed(0);
        AbstractCollections<Integer> stacks = new ArrayStack<>(12);
        for (int i = 0; i <= 10; i++)
            stacks.push(rand.nextInt(50));
        System.out.println(stacks);

        AbstractCollections<Integer> clonedStack = stacks.clone();


        System.out.println(clonedStack.hashCode());
        System.out.println(stacks.hashCode());
//
        System.out.println(stacks.equals(clonedStack));
        System.out.println(stacks.equals(stacks));
//        clonedStack.pop();
//        clonedStack2.pop();
//        stacks.pop();
//
//        clonedStack.pop();
//        clonedStack2.pop();
//        stacks.pop();
//
//        clonedStack.pop();
//        clonedStack2.pop();
//        stacks.pop();
//
//        System.out.println(clonedStack);
//        System.out.println(clonedStack2);
//        System.out.println(stacks);
//        assert stacks.size() == clonedStack.size();

        System.out.println(stacks);
//        System.out.println(clonedStack2.pop());
        System.out.println(clonedStack);
        System.out.println(stacks.copy().hashCode());
        System.out.println(stacks != stacks.copy());
        System.out.println(stacks.getClass() == stacks.copy().getClass());
        System.out.println(stacks.copy().equals(stacks));
        assert stacks.hashCode() != stacks.copy().hashCode();

        Map<Integer, String> map = new Hashtable<>();

        int[] intArray = {1, 2, 3, 4, 5, 6, 7};
        int[] intArrayCopied = Arrays.copyOf(intArray, intArray.length);
        int[] intArrayCloned = intArray.clone();

        System.out.println(Arrays.toString(intArrayCopied));
        System.out.println(intArray.hashCode());
        System.out.println(intArrayCopied != intArray);
        System.out.println(intArrayCloned != intArray);

        String[] stringArray = {"play", "sleep", "eat"};
        String[] stringArrayCopied = Arrays.copyOf(stringArray, stringArray.length);
        String[] stringArrayCloned = stringArray.clone();

        System.out.println(stringArray != stringArrayCopied);
        System.out.println(stringArray != stringArrayCloned);

    }


}
