package ch.zhaw.homework.le05;

import java.util.List;

public interface IOStrategy {

    public void serialize(List<String> data);
    public List<String> deserialize();
}
