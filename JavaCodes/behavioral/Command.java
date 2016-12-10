package JavaSE_Senior.DesignPattern.JavaCodes.behavioral;

public class Command {
	public static void main(String[] args) {
		//具体的命令执行者
		Student student = new Student();
		//具体的命令
		TaskCommand command = new ConcreteTask(student);
		//命令发布者
		Teacher teacher = new Teacher();
		//发布命令
		teacher.setCommandTask(command);
		//给我去做
		teacher.doHomeWork();
	}
}

class Student{
	void writeHomeWork(){
		System.out.println("I'm writing.... what the fucking homework!");
	}
}

/**
 * 命令调用者（发布者）
 */
class Teacher {
	private TaskCommand command;
	public void setCommandTask(TaskCommand command){
		this.command = command;
	}
	public void doHomeWork(){
		command.writeHomeWork();
	}
}

/**
 * 任务命令接口
 */
interface TaskCommand{
	//做作业去
	void writeHomeWork();
}

/**
 * 具体的命令实现
 */
class ConcreteTask implements TaskCommand{
	private Student student;

	public ConcreteTask(Student student) {
		this.student = student;
	}

	@Override
	public void writeHomeWork() {
		this.student.writeHomeWork();
	}

}