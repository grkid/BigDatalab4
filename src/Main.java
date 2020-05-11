import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.NullWritable;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;

public class Main {
    public static void main(String[] v) throws Exception
    {
        Configuration conf=new Configuration();
        Job job=Job.getInstance(conf,"SecondSort");

        job.setJarByClass(Main.class);

        job.setMapperClass(SortMapper.class);
        job.setMapOutputKeyClass(InputPair.class);
        job.setMapOutputValueClass(NullWritable.class);

        job.setReducerClass(SortReducer.class);
        job.setOutputKeyClass(InputPair.class);
        job.setOutputValueClass(NullWritable.class);

        if(v.length!=3)
        {
            System.err.println("Usage: <str> <in> <out>");
            System.exit(2);
        }

        FileInputFormat.addInputPath(job,new Path(v[1]));
        FileOutputFormat.setOutputPath(job,new Path(v[2]));
        System.exit(job.waitForCompletion(true)?0:1);
    }
}
