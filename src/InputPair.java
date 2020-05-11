import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.io.WritableComparable;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;

public class InputPair implements WritableComparable<InputPair> {

    private IntWritable n1;
    private IntWritable n2;

    public InputPair(){n1=new IntWritable(0);n2=new IntWritable(0);}

    public InputPair(IntWritable a1,IntWritable a2){n1=a1;n2=a2;}

    public InputPair(int a1,int a2)
    {
        n1=new IntWritable(a1);
        n2=new IntWritable(a2);
    }

    @Override
    public int compareTo(InputPair o) {
        //inc dec
        // this op o
        // <: -1
        // =: 0
        // >: 1
        int compare_n1=this.n1.compareTo(o.n1);
        if(compare_n1!=0)
            return compare_n1;//inc
        else
            return -this.n2.compareTo(o.n2);//dec
    }

    @Override
    public void write(DataOutput dataOutput) throws IOException {
        n1.write(dataOutput);
//        Text t=new Text("\t");
//        t.write(dataOutput);
        n2.write(dataOutput);
    }

    public String toString()
    {
        return n1+"\t"+n2;
    }

    @Override
    public void readFields(DataInput dataInput) throws IOException {
        n1.readFields(dataInput);
        n2.readFields(dataInput);
    }
}
