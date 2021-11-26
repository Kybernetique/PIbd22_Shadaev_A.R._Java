import javax.swing.*;
import java.util.HashMap;

public class HarborCollection
{
    // Словарь, хранящий места гавани
    final HashMap<String, Harbor<ITransport, InterAdd>> harborStages;

    // Возвращение списка названий мест гавани
    public DefaultListModel<Harbor<ITransport, InterAdd>> modelList;

    // Ширина окна отрисовки
    private final int pictureWidth;

    // Высота окна отрисовки
    private final int pictureHeight;

    // Конструктор
    public HarborCollection(int pictureWidth, int pictureHeight)
    {
        harborStages = new HashMap<>();
        this.pictureWidth = pictureWidth;
        this.pictureHeight = pictureHeight;
        modelList = new DefaultListModel<>();
    }

    // Добавление парковки
    public Harbor<ITransport, InterAdd> addHarbor(String name)
    {
        if (!harborStages.containsKey(name))
        {
            Harbor<ITransport, InterAdd> harbor = new Harbor<>(pictureWidth, pictureHeight);
            harbor.setName(name);
            harborStages.put(name, harbor);
            modelList.addElement(harbor);
            return harbor;
        }
        return null;
    }

    // Удаление парковки
    public void delHarbor(String name)
    {
        if (harborStages.containsKey(name))
        {
            Harbor harbor = harborStages.get(name);
            harborStages.remove(name);
            modelList.removeElement(harbor);
        }
    }

    /// Доступ к парковке
    public Harbor<ITransport, InterAdd> index(String ind)
    {
        return harborStages.getOrDefault(ind, null);
    }

    // Индексатор
    public ITransport index(String key, int index)
    {
        if (harborStages.containsKey(key))
        {
            return harborStages.get(key).indexer(index);
        }
        return null;
    }
}

