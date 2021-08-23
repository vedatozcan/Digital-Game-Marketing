
public interface IQueue 
{
	public void enqueue(User item) throws QueueFull;
	public User peek() throws QueueEmpty;
	public User dequeue() throws QueueEmpty;;
	public boolean isEmpty();
	public boolean contains(User user);
	public int size();

}
