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
        linkedListTest();
        arrayTest();
        arrayQueue();
        linkedStackTest();
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

    public static void linkedListTest() throws CloneNotSupportedException {
        Stacks<Integer> linkedStack = new LinkedStack<>();
        Random rand = new Random();
        rand.setSeed(0);
        for (int i = 0; i <= 10; i++)
            linkedStack.push(rand.nextInt(50));
        out.println("Linked Stack starts here " + linkedStack);

        Stacks<Integer> clonedLinkedStack;
        clonedLinkedStack = linkedStack.clone();
        out.println(clonedLinkedStack);
        assert linkedStack.equals(clonedLinkedStack);
        for (Integer integer : linkedStack)
            out.println(integer);

        out.println("Linked Stack ends here");

    }

    public static void arrayTest() {
        List<Integer> list = List.of(1, 4, 8, 9);
        out.println(list);
        out.println(list.size());
    }

    public static void arrayQueue() throws CloneNotSupportedException {
        Queue<Integer> queue = new ArrayQueue<>(20);
//        Random rand = new Random();
//        rand.setSeed(System.currentTimeMillis());
//        for (int i = 0; i <= 10; i++)
//            queue.enqueue(rand.nextInt(50));
//        out.println(queue);

        queue.enqueue(10);
        queue.enqueue(48);
        queue.dequeue();
        queue.enqueue(29);
        queue.enqueue(47);
        queue.enqueue(15);
        queue.dequeue();
        queue.enqueue(3);
        queue.enqueue(41);
        queue.enqueue(11);
        queue.dequeue();
        queue.enqueue(19);
        queue.enqueue(4);
        queue.enqueue(27);
        queue.dequeue();



        Queue<Integer> clonedQueue = queue.clone();
        Queue<Integer> copiedQueue = queue.copy();

        out.println("This is the original queue: " + queue);
        out.println(clonedQueue);
        out.println(copiedQueue);
        out.println(queue.equals(clonedQueue));
        out.println(queue.equals(copiedQueue));
        out.println(queue.equals(clonedQueue));
        out.println(queue.equals(copiedQueue));
        queue.dequeue();
        clonedQueue.dequeue();
        copiedQueue.dequeue();
        out.println(queue);
        out.println(clonedQueue);
        out.println(copiedQueue);
        assert queue.equals(clonedQueue);
        assert queue.equals(copiedQueue);
        assert clonedQueue.equals(copiedQueue);


    }

    public static void linkedStackTest() throws CloneNotSupportedException {
        Stacks<Integer> linkedStack = new LinkedStack<>();
        linkedStack.push(21);
        linkedStack.push(12);
        linkedStack.push(8);
        linkedStack.push(33);
        linkedStack.push(10);
        linkedStack.push(7);
        linkedStack.push(42);
        linkedStack.push(88);
        linkedStack.push(73);
        linkedStack.push(15);
        out.println();
        out.println("LinkedStack starts here");
        out.println(linkedStack);
        out.println(linkedStack.top());
        out.println(linkedStack.size());
        out.println(linkedStack);

        Stacks<Integer> clonedLinkedStack = linkedStack.clone();
        out.println(clonedLinkedStack);
        out.println(linkedStack.equals(clonedLinkedStack));
        out.println(linkedStack != clonedLinkedStack);
        out.println(clonedLinkedStack.equals(clonedLinkedStack));

        Stacks<Integer> testLinkedStack = new LinkedStack<>();
        testLinkedStack.push(21);
        testLinkedStack.push(12);
        testLinkedStack.push(8);
        testLinkedStack.push(33);
        testLinkedStack.push(10);
        testLinkedStack.push(7);
        testLinkedStack.push(42);
        testLinkedStack.push(88);
        testLinkedStack.push(73);
        testLinkedStack.push(15);


        out.println(clonedLinkedStack.equals(testLinkedStack));
        out.println(linkedStack.hashCode());
        out.println(clonedLinkedStack.hashCode());
        assert linkedStack.hashCode() == clonedLinkedStack.hashCode();
        assert linkedStack.hashCode() == testLinkedStack.hashCode();

        List<Integer> list = new ArrayList<>(12);
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(0);
        out.println(list.hashCode());


        Integer[] intList = new Integer[4];
        intList[0] = 1;
        intList[1] = 2;
        intList[2] = 3;
        intList[3] = 0;
        out.println();
        out.println(intList.hashCode());

    }

}
