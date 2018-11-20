package szu.vander.container.collectanditerator;

import java.util.Iterator;

import szu.vander.container.pet.Pet;
import szu.vander.container.pet.Pets;

/**
 * 
* @author      : Vander
* @date        : 2018-11-20
* @description : 生成Iterator是将队列与消费队列的方法连接在一起耦合度最小的方式，并且与实现Collection相比
* 				它在序列类上所施加的约束也少得多
 */
class PetSequence {
	protected Pet[] pets = Pets.createArray(8);
}

public class NonCollectionSequence extends PetSequence {
	public Iterator<Pet> iterator() {
		return new Iterator<Pet>() {
			private int index = 0;

			public boolean hasNext() {
				return index < pets.length;
			}

			public Pet next() {
				return pets[index++];
			}

			public void remove() { // Not implemented
				throw new UnsupportedOperationException();
			}
		};
	}

	public static void main(String[] args) {
		NonCollectionSequence nc = new NonCollectionSequence();
		InterfaceVsIterator.display(nc.iterator());
	}
} /*
	 * Output: 0:Rat 1:Manx 2:Cymric 3:Mutt 4:Pug 5:Cymric 6:Pug 7:Manx
	 */// :~
