package bar.dto;

import java.util.List;

public class DTO<T> {
    public String status;
    public List<T> drinks; //change to private

    public List<T> getList() {
        return drinks;
    }

    public void setList(List<T> list) {
        this.drinks = list;
    }

}
