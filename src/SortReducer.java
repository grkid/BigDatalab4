import org.apache.hadoop.io.NullWritable;
import org.apache.hadoop.mapreduce.Reducer;

import java.io.IOException;

public class SortReducer extends Reducer<InputPair, NullWritable,InputPair,NullWritable>
{
    @Override
    public void reduce(InputPair key,Iterable<NullWritable> values,Context c)
            throws IOException,InterruptedException
    {
        for(NullWritable n:values)
            c.write(key,NullWritable.get());
    }
}
