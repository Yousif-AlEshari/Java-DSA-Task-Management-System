# Task Management System — Data Structures & Algorithms (Java)

A console-based **Task Management System (TMS)** built from scratch using **custom linked lists and queues**, plus a set of standalone **algorithm demos** (sorting, amortized analysis, and shortest paths). This project was created for a Data Structures & Algorithms assignment to demonstrate core DS&A concepts in a practical context.

---

## Table of Contents
- [Features](#features)
- [Project Structure](#project-structure)
- [Requirements](#requirements)
- [Build & Run](#build--run)
- [How to Use (TMS CLI)](#how-to-use-tms-cli)
- [Data Structures & Design](#data-structures--design)
- [Algorithms Included (Demos)](#algorithms-included-demos)
- [Complexity Overview](#complexity-overview)
- [Known Behaviors & Limitations](#known-behaviors--limitations)
- [Author](#Author)

---

## Features
- Add tasks with: **name**, **ID**, **due date** (`yyyy-MM-dd`), **urgent** flag, and **category**
- Mark tasks as **completed**
- View:
  - **Completed tasks** (queue-based)
  - **Urgent tasks** (linked-list-based)
  - Tasks **ordered by due date** (merge sort on linked nodes)
  - Tasks **ordered by category** (lexicographic merge sort on linked nodes)
- Demonstrates fundamental DS&A:
  - Custom **singly linked list** and **linked queue**
  - **Merge sort** on node chains
  - **Amortized analysis** with dynamic arrays
  - **Shortest-path algorithms**: **Bellman–Ford** (with negative weights) and **Dijkstra** (non-negative)

---

## Project Structure

├── Main.java # CLI entry point for the Task Management System
├── TMS.java # Core TMS logic & user interactions
├── Task.java # Task model (name, id, dueDate, urgent, category, complete)
├── Node.java # Node<Task> for linked structures
├── LinkedList.java # Custom singly linked list of Task
├── QueueLinkedList.java # Custom queue of Task (linked)
│
├── EnhancedSelectionSort.java # Bidirectional selection sort demo
├── MergeSort.java # Array-based merge sort demo
├── ProfilingExample.java # Simple timing harness for merge sort
├── AmortizedAnalysisExample.java # ArrayList growth amortized O(1) demo
│
├── BellmanFordShortestPath.java # Shortest paths with negative weights support
└── DijkstraShortestPath.java # Shortest paths for non-negative weights (adjacency matrix)

---

## Requirements
- **Java 8+** (uses `java.time.LocalDate`)
- Any OS with a JDK installed (Windows, macOS, Linux)
- Terminal/console access

---

## Build & Run

### Compile everything
```bash
javac *.java
```
Tip: For extra checks, you can add -Xlint:

```
javac -Xlint:all *.java
```

Run the Task Management System (CLI)
```
java Main
```

Run the standalone algorithm demos
```
# Sorting / profiling
java EnhancedSelectionSort
java MergeSort
java ProfilingExample
java AmortizedAnalysisExample

# Shortest path algorithms
java BellmanFordShortestPath
java DijkstraShortestPath
```


## How to Use (TMS CLI)
When you run java Main, you’ll see a menu like:

- 1) Add task
- 2) Mark task complete
- 3) View completed tasks
- 4) View urgent tasks
- 5) View tasks ordered by due date
- 6) View tasks ordered by category
- 7) Exit


1) Add task
    You’ll be prompted for:

 - - Task name (string)

 - - Task ID (integer)

 - - Due date in format yyyy-MM-dd (e.g., 2025-08-19)

 - - Urgent? (true / false)

 - - Category (string)

    The task is appended to the master list; urgent tasks are additionally tracked in a separate list; tasks are also enqueued for date/category ordered views.

2) Mark task complete
    Enter the Task ID. The task is marked complete and a copy is enqueued into the completed tasks queue.

3 to 6) View tasks
    Each view prints the relevant tasks.
    Note: These print operations are destructive for the backing data structure (details below).

## Data Structures & Design
  - Task model (Task.java)
    name, id, dueDate (LocalDate), isUrgent, category, isComplete.

  - Custom singly linked list (LinkedList.java)
    Backed by Node (Task value, Node next).
    Operations used in TMS:

        insertBeginning, insertEnd

        deleteBeginning, deleteEnd, deleteAtIndex

        size

  - Custom queue (QueueLinkedList.java)
    front, rear, and counter with Enqueue, DeQueue, isEmpty, Size.

  - TMS core (TMS.java)
    Maintains:

        taskList (all tasks)

        urgentTaskList (urgent-only)

        completedTaskQueue

        dueDateTaskQueue and categoryTaskQueue (for sorted views)

        Sorting is done with merge sort directly on the node chains (mergeSort by date; mergeSortString by category), then the queues are printed by dequeuing.

## Algorithms Included (Demos)

### EnhancedSelectionSort.java
    Bidirectional selection sort: finds both min and max each pass and places them at the ends. Still O(n²) but with fewer passes than classic selection sort.

### MergeSort.java & ProfilingExample.java
    Standard top-down array merge sort using Arrays.copyOfRange(...). Basic timing examples.

### AmortizedAnalysisExample.java
    Demonstrates that ArrayList.add is amortized O(1) using System.nanoTime() to compute average time per insertion over many inserts.

### BellmanFordShortestPath.java
    Shortest paths allowing negative edge weights; detects negative cycles. O(V·E) time.

### DijkstraShortestPath.java
    Shortest paths on non-negative edges using an adjacency matrix and O(V²) selection of the next vertex.
- >Note: Uses 0 to represent “no edge”, so legitimate zero-weight edges are not supported in this demo implementation.

## Complexity Overview

### TMS Core

    Add task:
    taskList.insertEnd — O(n) (tail traversal)
    urgentTaskList.insertBeginning — O(1) (if urgent)
    Enqueue into views — O(1) each

    Mark complete:
    Search by ID in taskList — O(n)
    Enqueue into completed queue — O(1)

    View completed / urgent / ordered:
    Sorting for ordered views — O(k log k) where k is items in the queue
    Printing — O(k)
    (See destructive behavior note below)

### Demos

    Enhanced selection sort — O(n²)

    Merge sort — O(n log n) time, O(n) extra space

    Bellman–Ford — O(V·E) time, O(V) space

    Dijkstra (matrix) — O(V²) time, O(V) space

## Known Behaviors & Limitations
1) Destructive prints (by design in this assignment)
    Viewing completed, urgent, or ordered tasks empties the corresponding structure:

    - printCompletedTasks() dequeues everything.

    - printUrgentTasks() deletes nodes from the urgent list.

    - printOrderedTasks...() sorts the queue and then dequeues all items to print.

    The master taskList remains intact, so tasks aren’t lost, but the auxiliary “view” structures are cleared after each print.

2) Input format
    Due date must be entered as yyyy-MM-dd (e.g., 2025-08-19).

3) Dijkstra demo
    In the adjacency-matrix demo, 0 means “no edge”. That means edges with actual weight 0 cannot be represented in this specific demo.

## Author
Yousif Al Eshari