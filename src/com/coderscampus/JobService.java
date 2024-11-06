package com.coderscampus;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class JobService
	{
		public Job createJob(String line)
			{
				Job job = new Job();

				String info[] = line.split("\",\"");

				info[0] = info[0].replace("\"", "");

				info[2] = info[2].replace("\"", "");

				job.setTitle(info[0]);

				job.setCompany(info[1]);

				job.setCompensation(info[2]);

				return job;
			}

		public void writeJobInConsole(Job job)

			{
				if (job.getCompensation() != "")
					{
						System.out.println(job.getTitle());
						System.out.println(job.getCompany());
						System.out.println(job.getCompensation());
						System.out.println();
					}
			}

		public void readShowDocument(String documentName)
			{
				BufferedReader fileReader = null;
				try
					{
						fileReader = new BufferedReader(

								new FileReader(documentName));

						while (true)
							{
								String line = fileReader.readLine();

								if (line != null)
									{
										Job job = this.createJob(line);

										this.writeJobInConsole(job);

									} else
									{
										break;
									}
							}

					} catch (FileNotFoundException e)
					{
						System.out.println("The file wasn't found");
						e.printStackTrace();
					} catch (IOException e)
					{
						e.printStackTrace();
					} finally
					{
						try
							{
								fileReader.close();
							} catch (IOException e)
							{
								e.printStackTrace();
							}
					}
			}
	}
