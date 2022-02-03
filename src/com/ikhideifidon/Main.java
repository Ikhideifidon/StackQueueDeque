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

        AbstractCollections<Integer> otherStack = new ArrayStack<>();

        otherStack.push(17);
        otherStack.push(18);
        otherStack.push(19);
        otherStack.push(20);
        otherStack.push(21);

        AbstractCollections<Integer> stack = new ArrayStack<>();
        stack.push(17);
        stack.push(18);
        stack.push(19);
        stack.push(20);
        stack.push(21);
        assert stack.equals(otherStack): "Not Equal";

        for (Integer value : stacks)
            System.out.println(value);

        System.out.println(stacks.cloned().equals(stacks));
        System.out.println(stacks.isEmpty());
        System.out.println(stacks.pop());

        AbstractCollections<Integer> queue = new Queue<>();
        if (queue instanceof ArrayStack)
            System.out.println("yes");
        else
            System.out.println("No");

        List<Integer> myArrayList = new ArrayList<>();
        List<Integer> myAbstractList = new LinkedList<>();
        if (myArrayList instanceof LinkedList)
            System.out.println("yes");
        else
            System.out.println("No");

    }

}
