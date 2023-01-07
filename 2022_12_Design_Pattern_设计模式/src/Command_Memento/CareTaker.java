package Command_Memento;

import Decorator.Food;

import java.util.ArrayDeque;
import java.util.ArrayList;

public class CareTaker {
    //一个用于维护命令和备忘录的类
    private int mementoIndex = -1;
    private ArrayList<Memento> drinkOrderList = new ArrayList<Memento>();  //备忘录栈
    private ArrayDeque<Command> redoCommands = new ArrayDeque<>();    //redo命令栈
    private ArrayDeque<Command> commands = new ArrayDeque<>();    //命令栈

    //如果有了新的投喂动作，将新的食物状态保存在Memento中
    public void append(Command command, Memento memento) {
        mementoIndex++;
        commands.push(command);
        drinkOrderList.add(memento);
    }

    //如果undo,将备忘录栈最近状态pop出栈，同时commands最新命令出栈，并入栈redoCommands
    public void undo() {
        if (mementoIndex > 0) {
            Food food = commands.getLast().getMyFood();
            redoCommands.push(commands.pop());
            mementoIndex--;
            food.condiment = drinkOrderList.get(mementoIndex).getCondiment();
        } else {
            System.out.println("无剩余命令!");
        }
    }

    //如果redo，将redoCommands里的最新命令出栈，并入栈commands
    public void redo() throws InterruptedException {
        if (!redoCommands.isEmpty()) {
            redoCommands.getFirst().execute();
            commands.push(redoCommands.pop());
            mementoIndex++;
        } else {
            System.out.println("无剩余重做命令!");
        }
    }

    public void clear() {
        redoCommands.clear();
    }
}
