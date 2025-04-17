
Text2Talk slide show: [Text2Talk.pptx](https://github.com/user-attachments/files/19788510/Text2Talk.pptx)

Text2Talk.pptx text2talk uses FreeTTS Library( https://sourceforge.net/projects/freetts/ )

This program takes whatever you type into the top left box of the GUI and the program verbally repeats it back to you

the GUI features A large text area that allows users to type or paste the text they want to hear spoken. A dropdown menu lets users choose the voice (currently limited to "kevin16"). A slider adjusts the speaking speed, making it possible to slow down or speed up the voice depending on user preference. Once the settings are chosen and the text is ready, clicking the "Speak" button triggers the voice engine to read the text aloud.

Text2Talk helps individuals with visual impairments or reading difficulties by reading text aloud, Learners to hear correct pronunciations of typed words and phrases, Users can listen to notes, drafts, or written material hands-free,


-----break down of code--- 

**IMPORTS**

  import java.awt.*;
  import java.awt.event.*;
  import javax.swing.*;
  import com.sun.speech.freetts.*;

    java.awt.* and java.awt.event.* ➔ for layout (buttons, sliders, labels) and button clicks.
    javax.swing.* ➔ for GUI elements (window, text area, combo box).
    com.sun.speech.freetts.* ➔ for FreeTTS, the library that does the text-to-speech speaking.


**CLASS DECLARATION**

  public class Text2SpeechGUI extends JFrame {

    creates window 


**FIELDS**

private JTextArea textArea;
private JComboBox<String> voiceBox;
private JSlider speedSlider;
private JButton speakButton;

    textArea → where you type the text.
    voiceBox → a dropdown list to select voices (currently only "kevin16").
    speedSlider → a slider to control how fast the voice talks.
    speakButton → when clicked, it triggers the talking.

  

  




