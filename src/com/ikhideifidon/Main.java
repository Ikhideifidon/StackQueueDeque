package com.ikhideifidon;

import java.lang.management.ManagementFactory;
import java.util.*;
import static java.lang.System.out;

public class Main {

    public static void main(String[] args) throws CloneNotSupportedException, EmptyArrayQueueException, EmptyLinkedListException {
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
        linkedQueue();
    }

    public static void stackTest() throws CloneNotSupportedException, EmptyLinkedListException {
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
        stacks.pop();
        out.println();
        out.println();
        out.println(stacks);
        out.println(clonedStack);
//        assert stacks != copiedStack;
//        assert stacks.equals(copiedStack);
//        assert stacks.getClass() == copiedStack.getClass();
//        assert stacks.hashCode() == copiedStack.hashCode();
//        clonedStack.pop();
//        out.println(clonedStack);
//        out.println(stacks);
//        out.println(stacks.containsAll(clonedStack));
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

    public static void arrayQueue() throws CloneNotSupportedException, EmptyArrayQueueException, EmptyLinkedListException {
        Queue<Integer> queue = new ArrayQueue<>();
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
        queue.dequeue();
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
        queue.dequeue();
        queue.enqueue(100);
        queue.enqueue(4500);
        queue.enqueue(200);
        queue.enqueue(300);
        queue.enqueue(400);
        queue.enqueue(500);
        queue.dequeue();
        queue.enqueue(600);




        Queue<Integer> clonedQueue = queue.clone();
        Queue<Integer> copiedQueue = queue.copy();

        out.println("This is the original queue: " + queue);
        out.println(clonedQueue);
        out.println(copiedQueue);
        out.println(queue.equals(clonedQueue));
        out.println(queue.equals(copiedQueue));
        out.println(queue.equals(clonedQueue));
        out.println(queue.equals(copiedQueue));
        out.println(queue);
        out.println(clonedQueue);
        out.println(copiedQueue);
//        assert queue.equals(clonedQueue);
//        assert queue.equals(copiedQueue);
//        assert clonedQueue.equals(copiedQueue);
        out.println(queue.hashCode());
        out.println(queue.hashCode() == copiedQueue.hashCode());
        out.println(queue);
        out.println("ForEach loop starts here");
        out.println(queue);
        out.println(queue.copy());
        for (Integer integer : queue)
            out.println(integer);
        out.println(queue.contains(10000));
        copiedQueue.enqueue(111);
        copiedQueue.dequeue();
        copiedQueue.dequeue();
        copiedQueue.dequeue();
        copiedQueue.enqueue(566);
        out.println(copiedQueue);
        out.println(queue);

//        Queue<Integer> myQueue = new ArrayQueue<>();
//        myQueue.enqueue(11);
//        myQueue.enqueue(19);
//        myQueue.enqueue(4);
//        myQueue.enqueue(27);
//        myQueue.enqueue(1);
//        out.println(queue.containsAll(myQueue));



    }

    public static void linkedStackTest() throws CloneNotSupportedException, EmptyLinkedListException {
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
        Stacks<Integer> copiedLinkedStack = linkedStack.copy();
        out.println();
        out.println();
        out.println(copiedLinkedStack);
        out.println(clonedLinkedStack);
        linkedStack.pop();
        out.println(linkedStack);
        out.println(copiedLinkedStack);
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
//        assert linkedStack.hashCode() == clonedLinkedStack.hashCode();
//        assert linkedStack.hashCode() == testLinkedStack.hashCode();

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

    public static void linkedQueue() {
        Queue<Integer> linkedQueue = new LinkedQueue<>();
        linkedQueue.enqueue(28);
        linkedQueue.enqueue(2);
        linkedQueue.enqueue(5);
        linkedQueue.enqueue(15);
        linkedQueue.enqueue(3);
        linkedQueue.enqueue(12);
        linkedQueue.enqueue(8);
        out.println(linkedQueue);

        Queue<Integer> copiedLinkedQueue = linkedQueue.copy();
        linkedQueue.enqueue(560);
        out.println(linkedQueue);
        out.println(copiedLinkedQueue);

        SinglyLinkedList<Integer> s1 = new SinglyLinkedList<>();
        s1.addFirst(4);
        s1.addFirst(10);
        s1.addFirst(18);
        s1.addFirst(89);
        s1.addFirst(23);
        out.println(s1);

        SinglyLinkedList<Integer> s2 = s1.copy();
        s1.addFirst(78);
        s2.addFirst(100);
        out.println(s2);
        out.println(s1);

    }



}
