import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Vector;
import java.util.Random;
import java.util.Scanner;

abstract class Virus
{
    public int m_resistance;
    public String m_dna;

    public Virus()
    {
        m_resistance = 0;
        m_dna = "";
    }

    abstract void DoBorn();
    abstract Vector<Virus> DoClone();
    abstract void DoDie();
    abstract void InitResistance();
    public int m_resistance(int resistance)
    {
        m_resistance = resistance;
        return m_resistance;
    }

    public String m_dna(String dna)
    {
        m_dna = dna;
        return m_dna;
    }

    //load binary file
    void LoadADNInformation(String fileName)
    {
        File file = new File(fileName);
        FileInputStream fis = null;
        try
        {
            fis = new FileInputStream(file);
            int size = fis.available();
            byte[] buffer = new byte[size];
            fis.read(buffer);
            String str = new String(buffer);
            m_dna = str;
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }

    void ReduceResitance(int medicine_resistance)
    {
        m_resistance = m_resistance - medicine_resistance;
        if(m_resistance <= 0)
        {
            m_resistance = 0;
            System.out.println("Virus is dead");
        }
    }
}

class Dengue extends Virus
{
    String protein;

    @Override
    Vector<Virus> DoClone() {
        // duplikasi virus
        Dengue dengue = new Dengue();
        dengue.m_resistance = m_resistance;
        dengue.m_dna = m_dna;
        dengue.protein = protein;
        Vector<Virus> viruses = new Vector<Virus>();
        viruses.add(dengue);
        return viruses;
    }

    @Override
    void DoDie() {
        // TODO Auto-generated method stub
        System.out.println("Dengue is born");
    }

    @Override
    void InitResistance() {
        // TODO Auto-generated method stub
        super.m_resistance(15);
    }

    String setProtein(String protein)
    {
        this.protein = protein;
        return protein;
    }

    String getProtein()
    {
        return protein;
    }

    public Dengue(Dengue dengue)
    {
        super();
        this.protein = dengue.protein;
    }

    public Dengue() {
    }

    @Override
    void DoBorn() {
        // TODO Auto-generated method stub
        
    }

}

class Flue extends Virus
{
    int BLUE = 0x0000ff;
    int color = BLUE;

    @Override
    void DoBorn() {
        // TODO Auto-generated method stub
        System.out.println("Flue is born");
    }

    @Override
     Vector<Virus> DoClone() {
        // TODO Auto-generated method stub
        Flue flue = new Flue();
        flue.m_resistance = m_resistance;
        flue.m_dna = m_dna;
        Vector<Virus> viruses = new Vector<Virus>();
        viruses.add(flue);
        return viruses;
    }

    @Override
    void DoDie() {
        // TODO Auto-generated method stub
        System.out.println("Flue is dead");
    }

    @Override
    void InitResistance() {
        // TODO Auto-generated method stub
        super.m_resistance(10);
    }

    int setColor(int color)
    {
        this.color = color;
        return color;
    }

    int getColor()
    {
        return color;
    }

    public Flue(){}
    public Flue(Flue flue)
    {
        super();
        this.color = flue.color;
    }

}

class Patient extends Virus
{
   
    int DIE = 0;
    int ALIVE = 1;
    int m_state = 0;
    int m_resistance = 0;

    public Patient()
    {
        m_state = 50;
    }

    void DoStart()
    {
        if(m_state == DIE)
        {
            System.out.println("Patient is dead");
        }
        else
        {
            System.out.println("Patient is alive");
        }
    }

    void TakeMedicine(int medicine_resistance)
    {
        if(m_state == DIE)
        {
            DoDie();
        }
        else
        {
            ReduceResitance(medicine_resistance);
            if(m_resistance == 0)
            {
                m_state = DIE;
                DoDie();
            }
            else
            {
                System.out.println("Patient is alive");
            }
        }
    }

    int getState()
    {
        return m_state;
    }

    @Override
    void DoBorn() {
        // TODO Auto-generated method stub
        
    }

    @Override
    Vector<Virus> DoClone() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    void DoDie() {
        // TODO Auto-generated method stub
        System.out.println("Patient is dead");
        
    }

    @Override
    void InitResistance() {
        // TODO Auto-generated method stub
        super.m_resistance(10);
    }

}
public class App {
    public static void main(String[] args) throws Exception {
        Patient patient= new Patient();
        Random random= new Random();
        Scanner in= new Scanner(System.in);
        while(patient.getState() == 1) {
            System.out.println("Take Medicine (0 = NO, 1 = YES): ");
            String valueScan = in.next();
            if(valueScan.equalsIgnoreCase("1")) {
                int min= 0;
                int max= 8;
                patient.TakeMedicine(random.nextInt(max-min+ 1) + min);
            } else if(valueScan.equalsIgnoreCase("0")) {
                System.out.println("NOT TAKING MEDICINE!");
                patient.TakeMedicine(0);
            } else{
                System.out.println("INVALID");
                patient.DoDie();break;
            }
        }
        in.close();
        patient.DoDie();
    }
}