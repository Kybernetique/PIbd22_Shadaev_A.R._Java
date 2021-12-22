import javax.swing.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.*;

public class HarborCollection
{
    // Словарь (хранилище) с гаванями
    final HashMap<String, Harbor<ITransport, InterAdd>> harborStages;

    // Список названий гаваней
    public DefaultListModel<Harbor<ITransport, InterAdd>> modelList;

    // Ширина окна отрисовки
    private final int pictureWidth;

    // Высота окна отрисовки
    private final int pictureHeight;
    private final char separator = ':';

    // Конструктор
    public HarborCollection(int pictureWidth, int pictureHeight)
    {
        harborStages = new HashMap<>();
        this.pictureWidth = pictureWidth;
        this.pictureHeight = pictureHeight;
        modelList = new DefaultListModel<>();
    }

    // Добавление гавани
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

    // Удаление гавани
    public void delHarbor(String name)
    {
        if (harborStages.containsKey(name))
        {
            Harbor<ITransport, InterAdd> harbor = harborStages.get(name);
            harborStages.remove(name);
            modelList.removeElement(harbor);
        }
    }

    // Индексатор
    public Harbor<ITransport, InterAdd> indexer(String ind)
    {
        return harborStages.getOrDefault(ind, null);
    }

    // Индексатор
    public ITransport indexer(String key, int index)
    {
        if (harborStages.containsKey(key))
        {
            return harborStages.get(key).indexer(index);
        }
        return null;
    }

    // Метод для сохранения всех гаваней
    public boolean saveData(String filename) throws FileNotFoundException
    {
        File file = new File(filename);
        PrintWriter writer = new PrintWriter(file);
        writer.println("HarborCollection");
        for(Map.Entry<String, Harbor<ITransport, InterAdd>> harbor : harborStages.entrySet()){
            writer.println("Harbor"+separator+harbor.getKey());
            List<ITransport> list = harbor.getValue().get_places();
            for(ITransport boat : list){
                if(boat.getClass().equals(Boat.class)){
                    writer.println("Boat"+separator+boat.toString());
                }
                if(boat.getClass().equals(Sailboat.class)){
                    writer.println("Sailboat"+separator+boat.toString());
                }
            }
        }
        writer.close();
        return true;
    }

    // Метод для загрузки всех гаваней
    public boolean loadData(String filename)
            throws FileNotFoundException, HarborOverflowException, HarborAlreadyHaveException
    {
        Vehicle boat;
        File file = new File(filename);
        if (!file.exists())
        {
            throw new FileNotFoundException();
        }
        Scanner scanner = new Scanner(file);
        String line = scanner.nextLine(), key = "";
        if (!line.contains("HarborCollection"))
        {
            return false;
        }
        while (scanner.hasNextLine())
        {
            line = scanner.nextLine();
            if (line.contains("Harbor"))
            {
                key = line.split(String.valueOf(separator))[1];
                addHarbor(key);
            }
            else if (line.split(String.valueOf(separator))[0].equals("Boat"))
            {
                boat = new Boat(line.split(String.valueOf(separator))[1]);
                boolean result = harborStages.get(key).add(harborStages.get(key), boat);
                    return false;

            }
            else if (line.split(String.valueOf(separator))[0].equals("Sailboat"))
            {
                boat = new Sailboat(line.split(String.valueOf(separator))[1]);
                boolean result = harborStages.get(key).add(harborStages.get(key), boat);

                harborStages.get(key).add(boat);
            }
        }
        return true;
    }

    // Метод сохранения отдельной гавани
    public boolean saveDataFromHarbor(String filename, Harbor<ITransport, InterAdd> harbor) throws FileNotFoundException
    {
        File file = new File(filename);
        PrintWriter writer = new PrintWriter(file);
        writer.println("Harbor"+separator+harbor.getName());
        ArrayList<ITransport> list = harbor.get_places();
        for(ITransport boat : list){
            if(boat.getClass().equals(Boat.class)){
                writer.println("Boat"+separator+ boat);
            }
            if(boat.getClass().equals(Sailboat.class)){
                writer.println("Sailboat"+separator+ boat);
            }
        }
        writer.close();
        return true;
    }

    // Метод для загрузки отдельной гавани
    public boolean loadDataFromHarbor(String filename)
            throws FileNotFoundException, HarborOverflowException, HarborAlreadyHaveException
    {
        Vehicle boat;
        File file = new File(filename);
        if (!file.exists())
        {
            throw new FileNotFoundException();
        }
        Scanner scanner = new Scanner(file);
        String line, key = "";
        while (scanner.hasNextLine())
        {
            line = scanner.nextLine();
            if (line.contains("Harbor"))
            {
                key = line.split(String.valueOf(separator))[1];
                if (harborStages.containsKey(key))
                {
                    harborStages.get(key).get_places().clear();
                }
                else
                {
                    addHarbor(key);
                }
            }
            else if (line.split(String.valueOf(separator))[0].equals("Boat"))
            {
                boat = new Boat(line.split(String.valueOf(separator))[1]);
                boolean result = harborStages.get(key).add(harborStages.get(key), boat);

                harborStages.get(key).add(boat);
            }
            else if (line.split(String.valueOf(separator))[0].equals("Sailboat"))
            {
                boat = new Sailboat(line.split(String.valueOf(separator))[1]);
                boolean result = harborStages.get(key).add(harborStages.get(key), boat);

                harborStages.get(key).add(boat);
            }
        }
        return true;
    }
}

