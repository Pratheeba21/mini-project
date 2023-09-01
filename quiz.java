import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.shape.*;
import javafx.scene.*;
import javafx.event.*;
import javafx.scene.input.*;
import javafx.scene.text.*;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import java.io.*;
public class test extends Application
{
	public static void main(String w[])
	{
		launch();
	}
	public void start(Stage s)
	{
		File ff=new File("quiz.txt");
		if(!ff.exists())
		{	
			System.out.println("file not exists");
		}
		else
		{
			try
			{
			FileReader f11=new FileReader(ff);
			BufferedReader ss=new BufferedReader(f11);
			String gg;
			Label l[]=new Label[10];
			RadioButton r[]=new RadioButton[40];
			ToggleGroup t[]=new ToggleGroup[10];
			VBox v=new VBox();
			for(int r1=0,j=0;(gg=ss.readLine())!=null;)
			{
				l[j]=new Label(gg);
				t[j]=new ToggleGroup();
				v.getChildren().add(l[j]);
				for(int i=0;i<4;i++)
				{
					r[r1+i]=new RadioButton(ss.readLine());
					v.getChildren().add(r[r1+i]);
					r[r1+i].setToggleGroup(t[j]);
				}
				j++;
				r1+=4;
				System.out.println(gg);
			}
			ss.close();
			f11.close();
			Button b=new Button("Submit");
			Label l11=new Label();
			EventHandler<ActionEvent> f=new EventHandler<ActionEvent>()
			{
				public void handle(ActionEvent p)
				{
					int a=0;
					if(r[0].isSelected())
						a++;
					if(r[5].isSelected())
						a++;
					if(r[8].isSelected())
						a++;
					if(r[15].isSelected())
						a++;
					if(r[17].isSelected())
						a++;
					if(r[20].isSelected())
						a++;
					if(r[25].isSelected())
						a++;
					if(r[30].isSelected())
						a++;
					if(r[34].isSelected())
						a++;
					if(r[39].isSelected())
						a++;
					l11.setText("Your score="+a);
				}
			};
			b.setOnAction(f);
			v.getChildren().addAll(b,l11);
			Group g=new Group(v);
			Scene s1=new Scene(g);
			s.setScene(s1);
			s.setHeight(600);
			s.setWidth(1000);
			s.show();
		}
		catch(FileNotFoundException e)
		{
			System.out.println("file not found");
		}
		catch(IOException e)
		{
			System.out.println("invalid input");
		}
		catch(Exception e)
		{
			System.out.println();
		}
		}
	}
}
