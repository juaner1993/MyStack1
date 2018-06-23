import java.util.LinkedList;
import java.util.Queue;
/*
 * 通过给定类实现猫狗队列
 */
public class DogCatQueue {
	
	private static final String DOG = "dog";
	private static final String CAT = "cat";
	
	private Queue<PetEnterQueue> dogQ;//存放狗的队列
	private Queue<PetEnterQueue> catQ;//存放猫的队列
	private long count;//加入时间戳，标记存放的顺序
	
	public DogCatQueue() {
		dogQ = new LinkedList<PetEnterQueue>();
		catQ = new LinkedList<PetEnterQueue>();
		this.count = 0;
	}
	
	public void add(Pet pet) {
		if(pet.getPetType().equals(DOG)) {
			this.dogQ.add(new PetEnterQueue(pet,this.count++));
		} else if(pet.getPetType().equals(CAT)) {
			this.catQ.add(new PetEnterQueue(pet,this.count++));
		}else {
			throw new RuntimeException("err,not dog or cat");
		}
	}
	
	public Pet pollAll() {
		if(!this.dogQ.isEmpty() && !this.catQ.isEmpty()) {
			if(this.dogQ.peek().getCount() < this.catQ.peek().getCount()) {
				return this.dogQ.poll().getPet();
			}else {
				return this.catQ.poll().getPet();
			}
		}else if(!this.dogQ.isEmpty()) {
			return this.dogQ.poll().getPet();
		}else if(!this.catQ.isEmpty()) {
			return this.catQ.poll().getPet();
		}else {
			throw new RuntimeException("err,queue is empty!");
		}
 	}
	
	public Dog pollDog() {
		if(!this.isDogQueueEmpty()) {
			return (Dog) this.dogQ.poll().getPet();
		}else {
			throw new RuntimeException("err,Dog queue is empty!");
		}
	}
	
	public Cat pollCat() {
		if(!this.isCatQueueEmpty()) {
			return (Cat) this.catQ.poll().getPet();
		}else {
			throw new RuntimeException("err,Cat queue is empty!");
		}
	}
	
	public boolean isEmpty() {
		return this.dogQ.isEmpty() && this.catQ.isEmpty();
	}
	
	public boolean isDogQueueEmpty() {
		return this.dogQ.isEmpty();
	}
	
	public boolean isCatQueueEmpty() {
		return this.catQ.isEmpty();
	}
	
	public static void main(String[] args) {
		DogCatQueue dcq = new DogCatQueue();
		//System.out.println(dcq.isEmpty());
		for(int i=0;i<10;i++) {
			if((i&1) !=0) {
				dcq.add(new Pet(DOG));
			}else {
				dcq.add(new Pet(CAT));
			}
		}
		System.out.println("判断队列是否为空：" + dcq.isEmpty());
		System.out.println("判断狗队列是否为空：" + dcq.isDogQueueEmpty());
		System.out.println("判断猫队列是否为空：" + dcq.isCatQueueEmpty());
		
		while(!dcq.isEmpty()) {
			System.out.print(dcq.pollAll().getPetType() + " ");
		}

	}

}
//题目给的，不能随意修改
class Pet {
	
	private String type;
	
	public Pet(String type) {
		this.type = type;
	}

	public String getPetType() {
		return this.type;
	}
}
//题目给的，不能随意修改
class Dog extends Pet {

	public Dog() {
		super("dog");
	}
	
}
//题目给的，不能随意修改
class Cat extends Pet {

	public Cat() {
		super("cat");
	}
	
}
//本题实现将不同的实例盖上时间戳的方法，但又不能改变用户本身的类，所以定义一个新的类PetEnterQueue
class PetEnterQueue {
	private Pet pet;
	private long count;
	
	public PetEnterQueue(Pet pet, long count) {
		this.pet = pet;
		this.count = count;
	}
	
	public Pet getPet() {
		return this.pet;
	}
	
	public long getCount() {
		return this.count;
	}
	
	public String getEnterPetType() {
		return this.pet.getPetType();
	}
}