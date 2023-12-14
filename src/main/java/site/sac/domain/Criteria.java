package site.sac.domain;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString
@Setter
@Getter
public class Criteria {
    private long pageNum;
    private long perPageNum;
    public Criteria(){
        this.pageNum=1;
        this.perPageNum=5;
    }

}
