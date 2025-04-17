

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import com.sun.speech.freetts.*;

public class Text2SpeechGUI extends JFrame {
    private JTextArea textArea;
    private JComboBox<String> voiceBox;
    private JSlider speedSlider;
    private JButton speakButton;

    private static final String[] voices = {"kevin16"};

    public Text2SpeechGUI() {
        setTitle("Text to Speech");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        textArea = new JTextArea("Enter text here...");
        add(new JScrollPane(textArea), BorderLayout.CENTER);

        JPanel controlPanel = new JPanel();
        controlPanel.setLayout(new GridLayout(3, 2));

        voiceBox = new JComboBox<>(voices);
        controlPanel.add(new JLabel("Select Voice:"));
        controlPanel.add(voiceBox);

        speedSlider = new JSlider(100, 300, 150); // speed range
        speedSlider.setMajorTickSpacing(50);
        speedSlider.setPaintTicks(true);
        speedSlider.setPaintLabels(true);
        controlPanel.add(new JLabel("Speech Speed:"));
        controlPanel.add(speedSlider);

        speakButton = new JButton("Speak");
        controlPanel.add(speakButton);

        add(controlPanel, BorderLayout.SOUTH);

        speakButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                speak();
            }
        });
    }

    private void speak() {
        String text = textArea.getText();
        String voiceName = (String) voiceBox.getSelectedItem();
        int speed = speedSlider.getValue();

        VoiceManager vm = VoiceManager.getInstance();
        Voice voice = vm.getVoice(voiceName);

        if (voice != null) {
            voice.allocate();
            voice.setRate(speed);
            voice.speak(text);
            voice.deallocate();
        } else {
            JOptionPane.showMessageDialog(this, "Voice not found!", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new Text2SpeechGUI().setVisible(true);
        });
    }
}
