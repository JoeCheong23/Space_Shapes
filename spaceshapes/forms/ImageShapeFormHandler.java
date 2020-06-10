package spaceshapes.forms;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.concurrent.ExecutionException;

import javax.imageio.ImageIO;
import javax.swing.SwingWorker;

import spaceshapes.CarrierShape;
import spaceshapes.ImageRectangleShape;
import spaceshapes.ShapeModel;
import spaceshapes.forms.util.Form;
import spaceshapes.forms.util.FormHandler;

public class ImageShapeFormHandler implements FormHandler{

	private ShapeModel _model;
	private CarrierShape _parentOfNewShape;
	
	public ImageShapeFormHandler(ShapeModel shapeModel, CarrierShape carrierShape) {
		_model = shapeModel;
		_parentOfNewShape = carrierShape;
	}
	
	
	/**
	 * Reads form data that describes an ImageRectangleShape. Based on the 
	 * data, this SimpleImageShapeFormHandler creates a new ImageRectangleShape 
	 * object, adds it to a ShapeModel and to a CarrierShape within the model.
	 * 
	 * @param form the Form that contains the ImageRectangleShape data.
	 */
	@Override
	public void processForm(Form form) {
		final long startTime = System.currentTimeMillis();
		
		// Read field values from the form.
		final File imageFile = (File)form.getFieldValue(File.class, ImageFormElement.IMAGE);
		final int width = form.getFieldValue(Integer.class, ShapeFormElement.WIDTH);
		final int deltaX = form.getFieldValue(Integer.class, ShapeFormElement.DELTA_X);
		final int deltaY = form.getFieldValue(Integer.class, ShapeFormElement.DELTA_Y);
		
		SwingWorker<ImageRectangleShape, Void> workerThread = new SwingWorker<ImageRectangleShape, Void>() {

			@Override
			protected ImageRectangleShape doInBackground() throws Exception {
				// Load the original image (ImageIO.read() is a blocking call).
				BufferedImage fullImage = null;
				try {
					 fullImage = ImageIO.read(imageFile);
				} catch(IOException e) {
					System.out.println("Error loading image.");
				}
							
				int fullImageWidth = fullImage.getWidth();
				int fullImageHeight = fullImage.getHeight();
									
				BufferedImage scaledImage = fullImage;
				
				// Scale the image if necessary.
				if(fullImageWidth > width) {
					double scaleFactor = (double)width / (double)fullImageWidth;
					int height = (int)((double)fullImageHeight * scaleFactor);
							
					scaledImage = new BufferedImage(width,height,BufferedImage.TYPE_INT_RGB); 
					Graphics2D g = scaledImage.createGraphics();
							
					// Method drawImage() scales an already loaded image. The 
					// ImageObserver argument is null because we don't need to monitor 
					// the scaling operation.
					g.drawImage(fullImage, 0, 0, width, height, null);
				}
				
				// Create the new Shape and add it to the model.
				return new ImageRectangleShape(deltaX, deltaY, scaledImage);
			}
		
			@Override
			protected void done() {
				try {
					_model.add(get(), _parentOfNewShape);
				} catch (InterruptedException | ExecutionException e) {
					e.printStackTrace();
				}
				
				long elapsedTime = System.currentTimeMillis() - startTime;
				System.out.println("Image loading and scaling took " + elapsedTime + "ms.");
			}
		};
		workerThread.execute();
	}

}
