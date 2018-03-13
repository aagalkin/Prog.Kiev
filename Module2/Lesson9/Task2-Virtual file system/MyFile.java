import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

public class MyFile implements Serializable{
    private enum Types {DIR, FILE}
    private String name;
    private String path;
    private Set<MyFile> files;
    private Types type;

    public MyFile(String name){
        this.name = name;
        path = name;
        files = new HashSet<>();
    }

    public void mkdir(String name){
        MyFile newDir = new MyFile(name);
        newDir.setType(Types.DIR);
        newDir.path = this.path + "\\" + name;
        files.add(newDir);
    }

    public void mkfile(String name){
        MyFile newFile = new MyFile(name + ".file");
        newFile.setType(Types.FILE);
        newFile.path = this.path + "\\" + name;
        files.add(newFile);
    }

    public String getName() {
        return name;
    }

    public String getPath() {
        return path;
    }

    public void setType(Types type) {
        this.type = type;
    }

    public MyFile getFile(String name) {
        for (MyFile file : files){
            if (file.getName().equalsIgnoreCase(name)){
                return file;
            }
        }
        return null;
    }

    public void remove(String name){
        for (MyFile file : files){
            if (file.getName().equalsIgnoreCase(name)){
                files.remove(file);
            }
        }
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append(path).append(":\n");
        for (MyFile file : files){
            builder.append(file.getName()).append("\n");
        }
        return String.valueOf(builder);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        MyFile file = (MyFile) o;

        if (!name.equals(file.name)) return false;
        if (!path.equals(file.path)) return false;
        if (files != null ? !files.equals(file.files) : file.files != null) return false;
        return type == file.type;
    }

    @Override
    public int hashCode() {
        int result = name.hashCode();
        result = 31 * result + path.hashCode();
        result = 31 * result + (files != null ? files.hashCode() : 0);
        result = 31 * result + type.hashCode();
        return result;
    }
}