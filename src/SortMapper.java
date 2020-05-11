import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.NullWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

import java.io.IOException;

public class SortMapper extends Mapper<Object, Text,InputPair, NullWritable> {

    @Override
    public void map(Object key,Text value,Context c)
            throws IOException,InterruptedException
    {
        String str=value.toString();
        String[] strs=str.split("\t");
        c.write(new InputPair(Integer.parseInt(strs[0]),Integer.parseInt(strs[1])),NullWritable.get());
    }
}
