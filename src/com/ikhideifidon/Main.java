package com.ikhideifidon;

import java.lang.management.ManagementFactory;
import java.util.*;
import static java.lang.System.out;

public class Main {

    public static void main(String[] args) throws CloneNotSupportedException {
        if (!ManagementFactory.getRuntimeMXBean().getInputArguments().contains("-ea")) {
            out.println("Pass -ea to enable runtime assertions");
            return;
        }

        stackTest();
        intTest();
        stringTest();
    }

    public static void stackTest() throws CloneNotSupportedException {
        Random rand = new Random();
        rand.setSeed(0);
        Stacks<Integer> stacks = new ArrayStack<>(12);
        for (int i = 0; i <= 10; i++)
            stacks.push(rand.nextInt(50));
        out.println(stacks);
        // Pass -ea as a VM option in your run configuration for these asserts to have an effect
        assert stacks.equals(stacks);

        Stacks<Integer> clonedStack = stacks.clone();
        out.println(clonedStack);
        assert stacks != clonedStack;
        assert stacks.equals(clonedStack);
        assert stacks.getClass() == clonedStack.getClass();
        assert stacks.hashCode() == clonedStack.hashCode();

        Stacks<Integer> copiedStack = stacks.copy();
        out.println(copiedStack);
        assert stacks != copiedStack;
        assert stacks.equals(copiedStack);
        assert stacks.getClass() == copiedStack.getClass();
        assert stacks.hashCode() == copiedStack.hashCode();
    }

    public static void intTest() {
        int[] intArray = {1, 2, 3, 4, 5, 6, 7};

        int[] intArrayCopied = Arrays.copyOf(intArray, intArray.length);
        out.println(Arrays.toString(intArrayCopied));
        assert intArrayCopied != intArray;
        assert Arrays.equals(intArrayCopied, intArray);

        int[] intArrayCloned = intArray.clone();
        out.println(Arrays.toString(intArrayCloned));
        assert intArrayCloned != intArray;
        assert Arrays.equals(intArrayCloned, intArray);
    }

    public static void stringTest() {
        String[] stringArray = {"play", "sleep", "eat"};

        String[] stringArrayCopied = Arrays.copyOf(stringArray, stringArray.length);
        out.println(Arrays.toString(stringArrayCopied));
        assert stringArrayCopied != stringArray;
        assert Arrays.equals(stringArrayCopied, stringArray);

        String[] stringArrayCloned = stringArray.clone();
        out.println(Arrays.toString(stringArray));
        assert stringArrayCloned != stringArray;
        assert Arrays.equals(stringArrayCloned, stringArray);
    }
}
