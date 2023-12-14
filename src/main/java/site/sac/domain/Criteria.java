package site.sac.domain;

import lombok.Setter;

@Setter
public class Criteria {
    private long pageNum;
    private long perPageNum;
    public Criteria(){
        this.pageNum=1;
        this.perPageNum=5;
    }

}
