package net.eduard.api.lib.storage.references;

import java.util.List;

import net.eduard.api.lib.storage.StorageAPI;

public class ReferenceList extends ReferenceBase {

	private List<Integer> list;

	public ReferenceList(List<Integer> list,Object result) {
		super(null, result);
		setList(list);
	}

	@Override
	public void update() {
		@SuppressWarnings("unchecked")
		List<Object> newList = (List<Object>) getInstance();
		for (Integer item : list) {
			newList.add(StorageAPI.getObjectById(item));
		}
		try {
			getField().set(getInstance(), newList);
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public List<Integer> getList() {
		return list;
	}

	public void setList(List<Integer> list) {
		this.list = list;
	}

}
