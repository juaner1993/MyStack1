import java.util.LinkedList;
import java.util.Queue;
/*
 * ͨ��������ʵ��è������
 */
public class DogCatQueue {
	
	private static final String DOG = "dog";
	private static final String CAT = "cat";
	
	private Queue<PetEnterQueue> dogQ;//��Ź��Ķ���
	private Queue<PetEnterQueue> catQ;//���è�Ķ���
	private long count;//����ʱ�������Ǵ�ŵ�˳��
	
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
		System.out.println("�ж϶����Ƿ�Ϊ�գ�" + dcq.isEmpty());
		System.out.println("�жϹ������Ƿ�Ϊ�գ�" + dcq.isDogQueueEmpty());
		System.out.println("�ж�è�����Ƿ�Ϊ�գ�" + dcq.isCatQueueEmpty());
		
		while(!dcq.isEmpty()) {
			System.out.print(dcq.pollAll().getPetType() + " ");
		}

	}

}
//��Ŀ���ģ����������޸�
class Pet {
	
	private String type;
	
	public Pet(String type) {
		this.type = type;
	}

	public String getPetType() {
		return this.type;
	}
}
//��Ŀ���ģ����������޸�
class Dog extends Pet {

	public Dog() {
		super("dog");
	}
	
}
//��Ŀ���ģ����������޸�
class Cat extends Pet {

	public Cat() {
		super("cat");
	}
	
}
//����ʵ�ֽ���ͬ��ʵ������ʱ����ķ��������ֲ��ܸı��û�������࣬���Զ���һ���µ���PetEnterQueue
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