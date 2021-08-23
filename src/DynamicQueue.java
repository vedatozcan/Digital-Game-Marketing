import java.util.ArrayList;
import java.util.List;

public class DynamicQueue implements IQueue 
{
	private List<User> contents;

	public DynamicQueue()
	{
		contents = new ArrayList();
	}
	
	@Override
	public void enqueue(User item)
	{
		contents.add(item);

	}

	@Override
	public User peek() throws QueueEmpty
	{
		if (isEmpty())
			throw new QueueEmpty();

		return contents.get(0);
	}

	@Override
	public User dequeue() throws QueueEmpty {
		if (isEmpty())
			throw new QueueEmpty();

		User retVal = contents.get(0);
		contents.remove(0);
		
		return retVal;
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return contents.size() == 0;
	}

	@Override
	public boolean contains(User user) {
		if(contents.contains(user))
			return true;
		return  false;
	}

	@Override
	public int size()
	{
		return contents.size();
	}
	
	@Override
	public String toString()
	{
		int size = contents.size();
		
		String retString = "<" + size + ">\n<font:\n";
		
		for(int i=0; i<size; i++)
		{
			retString += contents.get(i) + "\n";
		}
		
		retString += ":rear>";
		
		return retString;
	}


}



