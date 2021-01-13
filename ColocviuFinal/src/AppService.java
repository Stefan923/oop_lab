import java.util.List;

public interface AppService<T> {

    public T create(T object);

    public List<T> search(String name);

    public boolean delete(T object) throws Exception;

}
